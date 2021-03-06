package entity;

import java.sql.Date;



/**
 * Auctionrecord entity. @author MyEclipse Persistence Tools
 */

public class Auctionrecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Auction auction;
	private Auctionuser auctionuser;
	private String auctiontime;
	private Double auctionprice;

	// Constructors

	/** default constructor */
	public Auctionrecord() {
	}

	/** minimal constructor */
	public Auctionrecord(Integer id, Auction auction, String auctiontime,
			Double auctionprice) {
		this.id = id;
		this.auction = auction;
		this.auctiontime = auctiontime;
		this.auctionprice = auctionprice;
	}

	/** full constructor */
	public Auctionrecord(Integer id, Auction auction, Auctionuser auctionuser,
			String auctiontime, Double auctionprice) {
		this.id = id;
		this.auction = auction;
		this.auctionuser = auctionuser;
		this.auctiontime = auctiontime;
		this.auctionprice = auctionprice;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Auction getAuction() {
		return this.auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public Auctionuser getAuctionuser() {
		return this.auctionuser;
	}

	public void setAuctionuser(Auctionuser auctionuser) {
		this.auctionuser = auctionuser;
	}

	public String getAuctiontime() {
		return this.auctiontime;
	}

	public void setAuctiontime(String auctiontime) {
		this.auctiontime = auctiontime;
	}

	public Double getAuctionprice() {
		return this.auctionprice;
	}

	public void setAuctionprice(Double auctionprice) {
		this.auctionprice = auctionprice;
	}

}