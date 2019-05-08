package kladionicaii.kladionica.pojoClassesRates;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class InnerClass {

	@JsonProperty("BGN")
	private BigDecimal BGN;
	@JsonProperty("NZD")
	private BigDecimal NZD;
	@JsonProperty("ILS")
	private BigDecimal ILS;
	@JsonProperty("RUB")
	private BigDecimal RUB;
	@JsonProperty("CAD")
	private BigDecimal CAD;
	@JsonProperty("USD")
	private BigDecimal USD;
	@JsonProperty("PHP")
	private BigDecimal PHP;
	@JsonProperty("CHF")
	private BigDecimal CHF;
	@JsonProperty("ZAR")
	private BigDecimal ZAR;
	@JsonProperty("AUD")
	private BigDecimal AUD;
	@JsonProperty("JPY")
	private BigDecimal JPY;
	@JsonProperty("TRY")
	private BigDecimal TRY;
	@JsonProperty("HKD")
	private BigDecimal HKD;
	@JsonProperty("MYR")
	private BigDecimal MYR;
	@JsonProperty("THB")
	private BigDecimal THB;
	@JsonProperty("HRK")
	private BigDecimal HRK;
	@JsonProperty("NOK")
	private BigDecimal NOK;
	@JsonProperty("IDR")
	private BigDecimal IDR;
	@JsonProperty("DKK")
	private BigDecimal DKK;
	@JsonProperty("CZK")
	private BigDecimal CZK;
	@JsonProperty("HUF")
	private BigDecimal HUF;
	@JsonProperty("GBP")
	private BigDecimal GBP;
	@JsonProperty("MXN")
	private BigDecimal MXN;
	@JsonProperty("KRW")
	private BigDecimal KRW;
	@JsonProperty("ISK")
	private BigDecimal ISK;
	@JsonProperty("SGD")
	private BigDecimal SGD;
	@JsonProperty("BRL")
	private BigDecimal BRL;
	@JsonProperty("PLN")
	private BigDecimal PLN;
	@JsonProperty("INR")
	private BigDecimal INR;
	@JsonProperty("RON")
	private BigDecimal RON;
	@JsonProperty("CNY")
	private BigDecimal CNY;
	@JsonProperty("SEK")
	private BigDecimal SEK;
	
	public InnerClass() {
	}

	public InnerClass(BigDecimal bGN, BigDecimal nZD, BigDecimal iLS, BigDecimal rUB, BigDecimal cAD, BigDecimal uSD, BigDecimal pHP,
			BigDecimal cHF, BigDecimal zAR, BigDecimal aUD, BigDecimal jPY, BigDecimal tRY, BigDecimal hKD,
			BigDecimal mYR, BigDecimal tHB, BigDecimal hRK, BigDecimal nOK, BigDecimal iDR, BigDecimal dKK,
			BigDecimal cZK, BigDecimal hUF, BigDecimal gBP, BigDecimal mXN, BigDecimal kRW, BigDecimal iSK,
			BigDecimal sGD, BigDecimal bRL, BigDecimal pLN, BigDecimal iNR, BigDecimal rON, BigDecimal cNY,
			BigDecimal sEK) {
		this.BGN = bGN;
		this.NZD = nZD;
		this.ILS = iLS;
		this.RUB = rUB;
		this.CAD = cAD;
		this.USD = uSD;
		this.PHP = pHP;
		this.CHF = cHF;
		this.ZAR = zAR;
		this.AUD = aUD;
		this.JPY = jPY;
		this.TRY = tRY;
		this.HKD = hKD;
		this.MYR = mYR;
		this.THB = tHB;
		this.HRK = hRK;
		this.NOK = nOK;
		this.IDR = iDR;
		this.DKK = dKK;
		this.CZK = cZK;
		this.HUF = hUF;
		this.GBP = gBP;
		this.MXN = mXN;
		this.KRW = kRW;
		this.ISK = iSK;
		this.SGD = sGD;
		this.BRL = bRL;
		this.PLN = pLN;
		this.INR = iNR;
		this.RON = rON;
		this.CNY = cNY;
		this.SEK = sEK;
	}

	public BigDecimal getBGN() {
		return BGN;
	}

	public void setBGN(BigDecimal bGN) {
		BGN = bGN;
	}

	public BigDecimal getNZD() {
		return NZD;
	}

	public void setNZD(BigDecimal nZD) {
		NZD = nZD;
	}

	public BigDecimal getILS() {
		return ILS;
	}

	public void setILS(BigDecimal iLS) {
		ILS = iLS;
	}

	public BigDecimal getRUB() {
		return RUB;
	}

	public void setRUB(BigDecimal rUB) {
		RUB = rUB;
	}

	public BigDecimal getCAD() {
		return CAD;
	}

	public void setCAD(BigDecimal cAD) {
		CAD = cAD;
	}

	public BigDecimal getUSD() {
		return USD;
	}

	public void setUSD(BigDecimal uSD) {
		USD = uSD;
	}

	public BigDecimal getPHP() {
		return PHP;
	}

	public void setPHP(BigDecimal pHP) {
		PHP = pHP;
	}

	public BigDecimal getCHF() {
		return CHF;
	}

	public void setCHF(BigDecimal cHF) {
		CHF = cHF;
	}

	public BigDecimal getZAR() {
		return ZAR;
	}

	public void setZAR(BigDecimal zAR) {
		ZAR = zAR;
	}

	public BigDecimal getAUD() {
		return AUD;
	}

	public void setAUD(BigDecimal aUD) {
		AUD = aUD;
	}

	public BigDecimal getJPY() {
		return JPY;
	}

	public void setJPY(BigDecimal jPY) {
		JPY = jPY;
	}

	public BigDecimal getTRY() {
		return TRY;
	}

	public void setTRY(BigDecimal tRY) {
		TRY = tRY;
	}

	public BigDecimal getHKD() {
		return HKD;
	}

	public void setHKD(BigDecimal hKD) {
		HKD = hKD;
	}

	public BigDecimal getMYR() {
		return MYR;
	}

	public void setMYR(BigDecimal mYR) {
		MYR = mYR;
	}

	public BigDecimal getTHB() {
		return THB;
	}

	public void setTHB(BigDecimal tHB) {
		THB = tHB;
	}

	public BigDecimal getHRK() {
		return HRK;
	}

	public void setHRK(BigDecimal hRK) {
		HRK = hRK;
	}

	public BigDecimal getNOK() {
		return NOK;
	}

	public void setNOK(BigDecimal nOK) {
		NOK = nOK;
	}

	public BigDecimal getIDR() {
		return IDR;
	}

	public void setIDR(BigDecimal iDR) {
		IDR = iDR;
	}

	public BigDecimal getDKK() {
		return DKK;
	}

	public void setDKK(BigDecimal dKK) {
		DKK = dKK;
	}

	public BigDecimal getCZK() {
		return CZK;
	}

	public void setCZK(BigDecimal cZK) {
		CZK = cZK;
	}

	public BigDecimal getHUF() {
		return HUF;
	}

	public void setHUF(BigDecimal hUF) {
		HUF = hUF;
	}

	public BigDecimal getGBP() {
		return GBP;
	}

	public void setGBP(BigDecimal gBP) {
		GBP = gBP;
	}

	public BigDecimal getMXN() {
		return MXN;
	}

	public void setMXN(BigDecimal mXN) {
		MXN = mXN;
	}

	public BigDecimal getKRW() {
		return KRW;
	}

	public void setKRW(BigDecimal kRW) {
		KRW = kRW;
	}

	public BigDecimal getISK() {
		return ISK;
	}

	public void setISK(BigDecimal iSK) {
		ISK = iSK;
	}

	public BigDecimal getSGD() {
		return SGD;
	}

	public void setSGD(BigDecimal sGD) {
		SGD = sGD;
	}

	public BigDecimal getBRL() {
		return BRL;
	}

	public void setBRL(BigDecimal bRL) {
		BRL = bRL;
	}

	public BigDecimal getPLN() {
		return PLN;
	}

	public void setPLN(BigDecimal pLN) {
		PLN = pLN;
	}

	public BigDecimal getINR() {
		return INR;
	}

	public void setINR(BigDecimal iNR) {
		INR = iNR;
	}

	public BigDecimal getRON() {
		return RON;
	}

	public void setRON(BigDecimal rON) {
		RON = rON;
	}

	public BigDecimal getCNY() {
		return CNY;
	}

	public void setCNY(BigDecimal cNY) {
		CNY = cNY;
	}

	public BigDecimal getSEK() {
		return SEK;
	}

	public void setSEK(BigDecimal sEK) {
		SEK = sEK;
	}

	@Override
	public String toString() {
		return "InnerClass [BGN=" + BGN + ", NZD=" + NZD + ", ILS=" + ILS + ", RUB=" + RUB + ", CAD=" + CAD + ", USD="
				+ USD + ", PHP=" + PHP + ", CHF=" + CHF + ", ZAR=" + ZAR + ", AUD=" + AUD + ", JPY=" + JPY + ", TRY="
				+ TRY + ", HKD=" + HKD + ", MYR=" + MYR + ", THB=" + THB + ", HRK=" + HRK + ", NOK=" + NOK + ", IDR="
				+ IDR + ", DKK=" + DKK + ", CZK=" + CZK + ", HUF=" + HUF + ", GBP=" + GBP + ", MXN=" + MXN + ", KRW="
				+ KRW + ", ISK=" + ISK + ", SGD=" + SGD + ", BRL=" + BRL + ", PLN=" + PLN + ", INR=" + INR + ", RON="
				+ RON + ", CNY=" + CNY + ", SEK=" + SEK + "]";
	}
	
	
	public HashMap<String, BigDecimal> populateMap() {
		HashMap<String, BigDecimal> hm = new HashMap<>();
		hm.put("BGN", this.getBGN());
		hm.put("NZD", this.getNZD());
		hm.put("ILS", this.getILS());
		hm.put("RUB", this.getRUB());
		hm.put("CAD", this.getCAD());
		hm.put("USD", this.getUSD());
		hm.put("PHP", this.getPHP());
		hm.put("CHF", this.getCHF());
		hm.put("ZAR", this.getZAR());
		hm.put("AUD", this.getAUD());
		hm.put("JPY", this.getJPY());
		hm.put("TRY", this.getTRY());
		hm.put("HKD", this.getHKD());
		hm.put("MYR", this.getMYR());
		hm.put("THB", this.getTHB());
		hm.put("HRK", this.getHRK());
		hm.put("NOK", this.getNOK());
		hm.put("IDR", this.getIDR());
		hm.put("DKK", this.getDKK());
		hm.put("CZK", this.getCZK());
		hm.put("HUF", this.getHUF());
		hm.put("GBP", this.getGBP());
		hm.put("MXN", this.getMXN());
		hm.put("KRW", this.getKRW());
		hm.put("ISK", this.getISK());
		hm.put("SGD", this.getSGD());
		hm.put("BRL", this.getBRL());
		hm.put("PLN", this.getPLN());
		hm.put("INR", this.getINR());
		hm.put("RON", this.getRON());
		hm.put("CNY", this.getCNY());
		hm.put("SEK", this.getSEK());
		return hm;
	}
	
}
