package com.SSE.reactive.service;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SSE.reactive.model.StockPrice;
import com.SSE.reactive.utils.Utils;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@Service
public class StockPriceService {

	@Autowired
	Utils utilities;
	Random random= new Random();  
	
	public Flux<List<StockPrice>> getStockPriceData(List<StockPrice> stockPriceList) {

		Flux<Long> interval = Flux.interval(Duration.ofSeconds(3));
		interval.subscribe((i) -> stockPriceList.forEach(stock -> setStockPrice(stock)));
		Flux<List<StockPrice>> transactionFlux = Flux.fromStream(Stream.generate(() -> stockPriceList));
		return Flux.zip(interval, transactionFlux).map(Tuple2::getT2);
	}

	private StockPrice setStockPrice(StockPrice stock) {
		Integer current = random.nextInt(50) ;
		Integer voltage = random.nextInt(50);
		stock.setCurrent(current);
		stock.setVoltage(voltage);
		stock.setStatus(current>voltage?"High":"Low");
		return stock;
	}

}
