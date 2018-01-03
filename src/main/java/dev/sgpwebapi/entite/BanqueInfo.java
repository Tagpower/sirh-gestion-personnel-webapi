package dev.sgpwebapi.entite;

import javax.persistence.Embeddable;

@Embeddable
public class BanqueInfo {
	
	//@Column(name="banque")
	private String banque;
	//@Column(name="bic")
	private String bic;
	//@Column(name="iban")
	private String iban;

	public BanqueInfo() {
		
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
	
	

}
