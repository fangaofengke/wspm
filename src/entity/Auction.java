package entity;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;



/**
 * Auction entity. @author MyEclipse Persistence Tools
 */

public class Auction implements java.io.Serializable {

	// Fields

	private Integer auctionid;
	private String auctionname;
	private Double auctionstartprice;
	private Double auctionupset;
	private String auctionstarttime;
	private String auctionendtime;
	private Blob auctionpic;
	private String auctionpictype;
	private String auctiondesc;
	private Set<Auctionrecord> auctionrecords = new HashSet<Auctionrecord>();
	private String priname;

	// Constructors

	/** default constructor */
	public Auction() {
	}

	/** minimal constructor */
	public Auction(Integer auctionid, String auctionname,
			Double auctionstartprice, Double auctionupset,
			String auctionstarttime, String auctionendtime, Blob auctionpic,
			String auctionpictype) {
		this.auctionid = auctionid;
		this.auctionname = auctionname;
		this.auctionstartprice = auctionstartprice;
		this.auctionupset = auctionupset;
		this.auctionstarttime = auctionstarttime;
		this.auctionendtime = auctionendtime;
		this.auctionpic = auctionpic;
		this.auctionpictype = auctionpictype;
	}

	/** full constructor */
	public Auction(Integer auctionid, String auctionname,
			Double auctionstartprice, Double auctionupset,
			String auctionstarttime, String auctionendtime, Blob auctionpic,
			String auctionpictype, String auctiondesc, Set auctionrecords) {
		this.auctionid = auctionid;
		this.auctionname = auctionname;
		this.auctionstartprice = auctionstartprice;
		this.auctionupset = auctionupset;
		this.auctionstarttime = auctionstarttime;
		this.auctionendtime = auctionendtime;
		this.auctionpic = auctionpic;
		this.auctionpictype = auctionpictype;
		this.auctiondesc = auctiondesc;
		this.auctionrecords = auctionrecords;
	}

	// Property accessors

	public Integer getAuctionid() {
		return this.auctionid;
	}

	public void setAuctionid(Integer auctionid) {
		this.auctionid = auctionid;
	}

	public String getAuctionname() {
		return this.auctionname;
	}

	public void setAuctionname(String auctionname) {
		this.auctionname = auctionname;
	}

	public Double getAuctionstartprice() {
		return this.auctionstartprice;
	}

	public void setAuctionstartprice(Double auctionstartprice) {
		this.auctionstartprice = auctionstartprice;
	}

	public Double getAuctionupset() {
		return this.auctionupset;
	}

	public void setAuctionupset(Double auctionupset) {
		this.auctionupset = auctionupset;
	}

	public String getAuctionstarttime() {
		return this.auctionstarttime;
	}

	public void setAuctionstarttime(String auctionstarttime) {
		this.auctionstarttime = auctionstarttime;
	}

	public String getAuctionendtime() {
		return this.auctionendtime;
	}

	public void setAuctionendtime(String auctionendtime) {
		this.auctionendtime = auctionendtime;
	}

	public Blob getAuctionpic() {
		return this.auctionpic;
	}

	public void setAuctionpic(Blob auctionpic) {
		this.auctionpic = auctionpic;
	}

	public String getAuctionpictype() {
		return this.auctionpictype;
	}

	public void setAuctionpictype(String auctionpictype) {
		this.auctionpictype = auctionpictype;
	}

	public String getAuctiondesc() {
		return this.auctiondesc;
	}

	public void setAuctiondesc(String auctiondesc) {
		this.auctiondesc = auctiondesc;
	}

	public Set<Auctionrecord> getAuctionrecords() {
		return auctionrecords;
	}

	public void setAuctionrecords(Set<Auctionrecord> auctionrecords) {
		this.auctionrecords = auctionrecords;
	}

	public String getPriname() {
		return priname;
	}

	public void setPriname(String priname) {
		this.priname = priname;
	}

	

}