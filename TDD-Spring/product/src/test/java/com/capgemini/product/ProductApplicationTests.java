package com.capgemini.product;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.product.entity.Product;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAddNewProduct() {
		Product product = new Product(101, "Grant", 10);

		try {
			this.mockMvc.perform(post("/product/")).andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("success")));
		} catch (Exception e) {
		}
	}

	@Test
	public void testProductDetailById() {

		try {
			this.mockMvc.perform(get("/product/detail/{101}")).andDo(print()).andExpect(status().isOk());
		} catch (Exception e) {
		}
	}

	@Test
	public void testProductUpdateById() {

		try {
			this.mockMvc.perform(put("/product/update/{101}/{Android Mobile}/{20}")).andDo(print()).andExpect(status().isOk());
		} catch (Exception e) {
		}
	}

	@Test
	public void testProductDeleteById() {

		try {
			this.mockMvc.perform(put("/product/delete/{101}")).andDo(print()).andExpect(status().isOk());
		} catch (Exception e) {
		}
	}

}
