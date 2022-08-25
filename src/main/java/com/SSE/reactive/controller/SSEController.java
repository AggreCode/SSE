package com.SSE.reactive.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SSE.reactive.model.StockPrice;
import com.SSE.reactive.service.StockPriceService;
import com.SSE.reactive.utils.Utils;

import reactor.core.publisher.Flux;

@RestController
public class SSEController {

	private List<StockPrice> stockPriceList = new ArrayList<>();
	@Autowired
	Utils utils;
	@Autowired
	StockPriceService stockPriceService;
	Random random= new Random();  
	
	@PostConstruct
	public void initializeStockObjects() {
		
		StockPrice stock1 = new StockPrice(
				random.nextInt(100),random.nextInt(10));
		
		StockPrice stock2 =  new StockPrice(
				random.nextInt(10),random.nextInt(100));
		
		StockPrice stock3 =  new StockPrice(
				random.nextInt(50),random.nextInt(5));
			
		stockPriceList.add(stock1);
		stockPriceList.add(stock2);
		stockPriceList.add(stock3);
	}
	
	@RequestMapping(value="/stockprice", method=RequestMethod.GET, produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<List<StockPrice>> getStockPrice() {
		return stockPriceService.getStockPriceData(stockPriceList);
	}
	
}
