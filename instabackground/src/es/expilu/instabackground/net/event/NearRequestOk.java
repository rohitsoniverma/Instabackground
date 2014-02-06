package es.expilu.instabackground.net.event;

import es.expilu.instabackground.model.Envelope;

public class NearRequestOk {

	public Envelope envelope;

	public NearRequestOk(Envelope envelope) {
		this.envelope = envelope;
	}
}
