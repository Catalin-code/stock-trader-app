package com.codecool.stockTrader;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;


public class Trader {

	private final StockAPIService stockService;
	private final FileLogger logger;

	public Trader(StockAPIService stockService, FileLogger logger){
		this.stockService = stockService;
		this.logger = logger;
	}


	public boolean buy(String symbol, double bid) throws IOException {
		double price = stockService.getPrice(symbol);

        boolean result;
		if (price <= bid) {
			result = true;
			stockService.buy(symbol);
			logger.log("Purchased " + symbol + " stock at $" + bid + ", since its higher that the current price ($" + price + ")");
		}
		else {
            logger.log("Bid for " + symbol + " was $" + bid + " but the stock price is $" + price + ", no purchase was made.");
			result = false;
		}
		return result;
	}

}