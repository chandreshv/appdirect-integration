package chandresh.confMgmt.dto;


public class UserDTO {

		private int userId;
		private Creator creator;
		private Marketplace marketplace;
		private Payload payload;
		private String type;

		public Payload getPayload() {
			return payload;
		}

		public void setPayload(Payload payload) {
			this.payload = payload;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Marketplace getMarketplace() {
			return marketplace;
		}

		public void setMarketplace(Marketplace marketplace) {
			this.marketplace = marketplace;
		}

		public Creator getCreator() {
			return creator;
		}

		public void setCreator(Creator creator) {
			this.creator = creator;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}
}
