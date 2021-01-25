package mark;

public class TV {

	//애니메이션은 "애니메이션입니다"
	//아니면 "애니메이션이 아닙니다"
	//라고 println으로 출력하는 메소드
	
	//클래스 배열이니까 안에 toString 재정의 해서 이름 출력해줄 수 있어
	void checkAni(Video[] arVideo) {
		String msg = null;
		for (int i = 0; i < arVideo.length; i++) {
			if(arVideo[i] instanceof Animation) {
				msg = arVideo[i]+"은/는 애니메이션입니다.";
			}else {
				msg = arVideo[i]+"은/는 애니메이션이 아닙니다.";
			}
			//일괄처리
			System.out.println(msg);
		}
	}
	
	
	
	public static void main(String[] args) {
		Video[] arVideos = {
				new Zzangu(),
				new Titanic(),
				new Dolbee(),
				new Dooly()
		};
		new TV().checkAni(arVideos);
	}

}
