package it.uniroma3.diadia.enums;


public enum Direzioni {

	NORD(0) {
		@Override
		public Direzioni opposta() {
			return SUD;
		}
	},
	EST(90) {
		@Override
		public Direzioni opposta() {
			return OVEST;
		}
	},
	SUD(180) {
		@Override
		public Direzioni opposta() {
			return NORD;
		}
	},
	OVEST(270) {
		@Override
		public Direzioni opposta() {
			return EST;
		}
	};
	private final int gradi;

	private Direzioni(int gradi) {
		this.gradi = gradi;
	}

	public int getGradi() {
		return this.gradi;
	}

	public abstract Direzioni opposta();
}