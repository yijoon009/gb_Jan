package dto;

public class BoxOfficeDTO {
	private int ranking;
	private String filmName;
	private String releaseDate;
	private long income;
	private int guestCnt;
	private int screenCnt;
	
	public BoxOfficeDTO() {;}
	
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public int getGuestCnt() {
		return guestCnt;
	}
	public void setGuestCnt(int guestCnt) {
		this.guestCnt = guestCnt;
	}
	public int getScreenCnt() {
		return screenCnt;
	}
	public void setScreenCnt(int screenCnt) {
		this.screenCnt = screenCnt;
	}
	
	
}
