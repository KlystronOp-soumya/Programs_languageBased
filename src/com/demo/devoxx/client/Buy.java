package com.demo.devoxx.client;

import java.math.BigDecimal;

import lombok.Data;

@Data
public final class Buy implements Trade {

	private String ticker;
	private BigDecimal amount;

	public Buy(String ticker, BigDecimal amount) {
		super();
		this.ticker = ticker;
		this.amount = amount;
	}

	@Override
	public void perform() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
		result = prime * result + ((this.ticker == null) ? 0 : this.ticker.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buy other = (Buy) obj;
		if (this.amount == null) {
			if (other.amount != null)
				return false;
		} else if (!this.amount.equals(other.amount))
			return false;
		if (this.ticker == null) {
			if (other.ticker != null)
				return false;
		} else if (!this.ticker.equals(other.ticker))
			return false;
		return true;
	}

}
