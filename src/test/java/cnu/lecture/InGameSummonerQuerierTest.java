package cnu.lecture;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by tchi on 2016. 4. 25..
 */
public class InGameSummonerQuerierTest {
	private InGameSummonerQuerier querier;

	@Before
	public void setup() {
		final String apiKey = "8242f154-342d-4b86-9642-dfa78cdb9d9c";
		GameParticipantListener dontCareListener = mock(GameParticipantListener.class);

		querier = new InGameSummonerQuerier(apiKey, dontCareListener);
	}

	@Test
	public void shouldQuerierIdentifyGameKeyWhenSpecificSummonerNameIsGiven() throws Exception {
		final String summonerName;
		boolean state = true;
		
		GIVEN: { // 특정 값이 주어지고
			//summonerName = "akane24";
			summonerName = "방학잉여";
		}

		final String actualGameKey;
		WHEN: { // 어떤 이벤트가 발생했을 때
			actualGameKey = querier.queryGameKey(summonerName);
			if(actualGameKey.equals("a")){
				state = false;
			}
		}

		final String expectedGameKey = "4/bl4DC8HBir8w7bGHq6hvuHluBd+3xM";
		THEN: { // 그에 대한 결과를 보장해야한다
			if(state == false)
				System.out.println("소환자는 현재 게임중이 아닙니다.");
			else
				assertThat(actualGameKey, is(expectedGameKey));
		}
	}
}
