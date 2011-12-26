package nicovideo4j;

import java.util.List;
import java.util.Map;

public class NicoVideo {

	private boolean status;
	private String id;
	private String title;
	private String description;
	private String thumbnailUrl;
	private String firstRetrive;
	private String length;
	private String movieType;
	private long sizeHigh;
	private long sizeLow;
	private long viewCounter;
	private long commentNum;
	private long myListCounter;
	private String lastResBody;
	private String watchUrl;
	private String thumbType;
	private int embeddable;
	private int noLivePlay;
	private Map<String,List<String>> tags;
	private String userId;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return　動画のID
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return　動画のタイトル
	 */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return　動画の説明
	 */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return　サムネイルのURL
	 */
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	/**
	 * サムネイル
	 * @param thumbnailUrl
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	/**
	 * @return　投稿日時
	 */
	public String getFirstRetrive() {
		return firstRetrive;
	}
	public void setFirstRetrive(String firstRetrive) {
		this.firstRetrive = firstRetrive;
	}
	/**
	 * @return　動画の長さ
	 */
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	/**
	 * @return　動画の拡張子
	 */
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public long getSizeHigh() {
		return sizeHigh;
	}
	public void setSizeHigh(long sizeHigh) {
		this.sizeHigh = sizeHigh;
	}
	public long getSizeLow() {
		return sizeLow;
	}
	public void setSizeLow(long sizeLow) {
		this.sizeLow = sizeLow;
	}
	public long getViewCounter() {
		return viewCounter;
	}
	public void setViewCounter(long viewCounter) {
		this.viewCounter = viewCounter;
	}
	public long getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(long commentNum) {
		this.commentNum = commentNum;
	}
	public long getMyListCounter() {
		return myListCounter;
	}
	public void setMyListCounter(long myListCounter) {
		this.myListCounter = myListCounter;
	}
	public String getLastResBody() {
		return lastResBody;
	}
	public void setLastResBody(String lastResBody) {
		this.lastResBody = lastResBody;
	}
	public String getWatchUrl() {
		return watchUrl;
	}
	public void setWatchUrl(String watchUrl) {
		this.watchUrl = watchUrl;
	}
	public String getThumbType() {
		return thumbType;
	}
	public void setThumbType(String thumbType) {
		this.thumbType = thumbType;
	}
	public int getEmbeddable() {
		return embeddable;
	}
	public void setEmbeddable(int embeddable) {
		this.embeddable = embeddable;
	}
	public int getNoLivePlay() {
		return noLivePlay;
	}
	public void setNoLivePlay(int noLivePlay) {
		this.noLivePlay = noLivePlay;
	}
	public Map<String, List<String>> getTags() {
		return tags;
	}
	public void setTags(Map<String, List<String>> tags) {
		this.tags = tags;
	}
	/**
	 * @return 投稿者のユーザID
	 */
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
}
