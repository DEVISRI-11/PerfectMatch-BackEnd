package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins="*")
public class PerfectController {
	@Autowired
	PerfectRepo perfectRepo;
	
	@GetMapping("/perfect/find")
	public Perfect findById(@RequestParam int id) {
		
		
		 Perfect perfect =perfectRepo.findById(id).get();
		 
		 perfect.setImage(decompressBytes(perfect.getImage()));
		 
		 return perfect;
		
	}
	
	@PostMapping("/perfect/add")
	public String addProduct(@RequestParam ("dietFile") MultipartFile myFile,
			String name,
			String dob,
			String gender,
			String qualification,
			String height,
			String address,
			String phone,
			String caste) {
		
		try {
			Perfect prdImage = new Perfect(name,dob,gender,qualification,height,address,phone,caste,
					compressBytes(myFile.getBytes()));
			perfectRepo.save(prdImage);		
		}catch(Exception e) {
			
		}
		
		
		
		return "Successfully Added New Perfect";
		
	}
	
	@GetMapping("/perfect/delete")
	public List<Perfect> deletePerfect(@RequestParam int id){
		perfectRepo.deleteById(id);
		
		return getAllProducts();
	}
	@GetMapping("/perfect/all")
	public List<Perfect> getAllProducts(){
		
		List<Perfect> drList = new ArrayList<Perfect>();
		
		List<Perfect> resDrList = perfectRepo.findAll();
		Perfect perfect = null;
		for(int i=0;i<resDrList.size();i++) {
			
			perfect= resDrList.get(i);
			
			perfect.setImage(decompressBytes(perfect.getImage()));
			
			drList.add(perfect);
			
		}
		
		
		return drList;
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


}