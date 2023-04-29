package sk.fzdp.ciphers.cezar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CezarController {
	
	/** Flag for waiting when enabled */
    private boolean timeout = false;
    /** Flag for throwing a 503 when enabled */
    private boolean misbehave = false;

	@Autowired
	private CezarService cezarService;

	@RequestMapping(path = "/cezar/encode/{text}", method = RequestMethod.GET)
	public String encodeCezar(@PathVariable String text) {
		if (timeout) {
			try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	        }
        }
        if (misbehave) {
        	throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Service misbehaving...");
        }
		return cezarService.encode(text);
	}
	
	@RequestMapping(path = "/cezar/decode/{text}", method = RequestMethod.GET)
	public String decodeCezar(@PathVariable String text) {

		return cezarService.decode(text);
	}
	
	@RequestMapping(path = "/cezar/timeout", method = RequestMethod.GET)
    public String flagTimeout() {
        this.timeout = true;
        return "Ok";
    }

	@RequestMapping(path = "/cezar/timein", method = RequestMethod.GET)
    public String flagTimein() {
        this.timeout = false;
        return "Ok";
    }

	@RequestMapping(path = "/cezar/misbehave", method = RequestMethod.GET)
    public String flagMisbehave() {
        this.misbehave = true;
        return "Ok";
    }

	@RequestMapping(path = "/cezar/behave", method = RequestMethod.GET)
    public String flagBehave() {
        this.misbehave = false;
        return "Ok";
    }
}
