package com.demo.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProcessor {
	public static EmployeeDTO convertJsonToDTO(String jsonFilePath) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Employee employee = objectMapper.readValue(new File(jsonFilePath), Employee.class);
			return new EmployeeDTO(employee.getId(), employee.getName(), employee.getAddress().getCity());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void saveDTOToJson(EmployeeDTO dto, String outputFilePath) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File(outputFilePath), dto);
			System.out.println("DTO data saved to " + outputFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EmployeeDTO dto = convertJsonToDTO("..\\JavaDemos\\employee.json");// using the relative path
		if (dto != null) {
			System.out.println("EmployeeDTO: " + dto.getName() + ", " + dto.getCity());
			saveDTOToJson(dto, "..\\JavaDemos\\empwrite.json");
		}
	}
}
