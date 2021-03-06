package ch.newaccess.backendproject.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.PieceDeCaisse;
import ch.newaccess.backendproject.entities.ImageModel;
import ch.newaccess.backendproject.repository.IimageRepository;
import ch.newaccess.backendproject.service.AccountService;
@RestController
public class ImageController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	IimageRepository imageRepository;
	@PostMapping("/add-image")
	public ImageModel addImage(@RequestParam("imageFile") MultipartFile file,@RequestParam("user") String username) throws IOException {
		System.out.println("Original Image Byte Size ************* - " + file.getBytes().length);
		//,@RequestParam("user") AppUser username
		AppUser user=accountService.findUserByUsername(username);
		if(imageRepository.findByUser(user).isEmpty()) {

			ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),compressBytes(file.getBytes()));
			img.setUser(user);
			
			return imageRepository.save(img);
		}else {
			ImageModel image=imageRepository.findByUser(user).get();
			image.setName(file.getOriginalFilename());
			image.setPicByte(compressBytes(file.getBytes()));
			image.setType(file.getContentType());
			
			return imageRepository.save(image);
		
		}
		
	}
	// compress the image bytes before storing it in the database
			public static byte[] compressBytes(byte[] data) {
				Deflater deflater = new Deflater();
				deflater.setInput(data);
				deflater.finish();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				while (!deflater.finished()) {
					int count = deflater.deflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				try {
					outputStream.close();
				} catch (IOException e) {
				}
				System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
				return outputStream.toByteArray();
			}
			// uncompress the image bytes before returning it to the angular application
			public static byte[] decompressBytes(byte[] data) {
				Inflater inflater = new Inflater();
				inflater.setInput(data);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				try {
					while (!inflater.finished()) {
						int count = inflater.inflate(buffer);
						outputStream.write(buffer, 0, count);
					}
					outputStream.close();
				} catch (IOException ioe) {
				} catch (DataFormatException e) {
				}
				return outputStream.toByteArray();
			}
			
			@GetMapping("image")
			public ImageModel getImage(@RequestParam("userName") String userName) throws IOException {
				AppUser user=accountService.findUserByUsername(userName);
				if(imageRepository.findByUser(user).isEmpty()) 
				{return null;}
				else
				{
				final Optional<ImageModel> retrievedImage = imageRepository.findByUser(user);
				ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
						decompressBytes(retrievedImage.get().getPicByte()));
			
				return img;}
			}
}
