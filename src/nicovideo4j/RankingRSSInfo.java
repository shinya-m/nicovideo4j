package nicovideo4j;

import java.io.Serializable;

public class RankingRSSInfo implements Serializable{

	private static final long serialVersionUID = -1196241298475422768L;

	private String title;
	private String link;
	private String guid;
	private String pubDate;
	private String description;
	private String thumbnailUrl;
	//広告ポイント
	private int number;
	//再生時間
	private String length;
	//投稿日
	private String date;
	private int totalView;
	private int totalRes;
	private int totalMyList;
	private int dailyView;
	private int dailyRes;
	private int dailyMyList;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotalView() {
		return totalView;
	}
	public void setTotalView(int totalView) {
		this.totalView = totalView;
	}
	public int getTotalRes() {
		return totalRes;
	}
	public void setTotalRes(int totalRes) {
		this.totalRes = totalRes;
	}
	public int getTotalMyList() {
		return totalMyList;
	}
	public void setTotalMyList(int totalMyList) {
		this.totalMyList = totalMyList;
	}
	public int getDailyView() {
		return dailyView;
	}
	public void setDailyView(int dailyView) {
		this.dailyView = dailyView;
	}
	public int getDailyRes() {
		return dailyRes;
	}
	public void setDailyRes(int dailyRes) {
		this.dailyRes = dailyRes;
	}
	public int getDailyMyList() {
		return dailyMyList;
	}
	public void setDailyMyList(int dailyMyList) {
		this.dailyMyList = dailyMyList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	
}
