package cnu.lecture;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tchi on 2016. 4. 25..
 */
public class InGameInfo {
    public static class Observer {
        @Getter @Setter
        private String encryptionKey;

		public String getEncryptionKey() {
			return encryptionKey;
		}

	
    }

    public static class Participant {
        @Getter @Setter
        private String summonerName;

		public String getSummonerName() {
			return summonerName;
		}


    }

    @Getter @Setter
    private String platformId;

    @Getter @Setter
    private Observer observers;

    public Observer getObservers() {
		return observers;
	}

	@Getter @Setter
    private Participant[] participants;

	public Participant[] getParticipants() {
		return participants;
	}



}
