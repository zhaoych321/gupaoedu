package config.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("somethingService")
public class SomethingService implements ISomethingService {

	public void doesTest() {
		System.out.println("hey judy !!!!");
	}
	
	public void hello() {
		System.out.println("hello.....");
	}
	
	public void doPrint() {
		System.out.println("ppppppppppppppppppppp");
	}
}
