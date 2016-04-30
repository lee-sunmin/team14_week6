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
		
		GIVEN: { // Ư�� ���� �־�����
			//summonerName = "akane24";
			summonerName = "�����׿�";
		}

		final String actualGameKey;
		WHEN: { // � �̺�Ʈ�� �߻����� ��
			actualGameKey = querier.queryGameKey(summonerName);
			if(actualGameKey.equals("a")){
				state = false;
			}
		}

		final String expectedGameKey = "4/bl4DC8HBir8w7bGHq6hvuHluBd+3xM";
		THEN: { // �׿� ���� ����� �����ؾ��Ѵ�
			if(state == false)
				System.out.println("��ȯ�ڴ� ���� �������� �ƴմϴ�.");
			else
				assertThat(actualGameKey, is(expectedGameKey));
		}
	}
}
