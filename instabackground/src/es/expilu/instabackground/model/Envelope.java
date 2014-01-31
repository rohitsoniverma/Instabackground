package es.expilu.instabackground.model;

public class Envelope {

	private Meta meta;
	private EnvelopeData[] data;	

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public EnvelopeData[] getData() {
		return data;
	}

	public void setData(EnvelopeData[] data) {
		this.data = data;
	}
}
