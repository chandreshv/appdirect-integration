package chandresh.confMgmt.dto;

import java.util.UUID;

public class UserDTO {

		private AddressDTO address;
		private String email;
		private String firstName;
		private String lastName;
		private String locale;
		private String openId;
		private UUID uuid;
		private int userId;
		

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getLocale() {
			return locale;
		}

		public void setLocale(String locale) {
			this.locale = locale;
		}

		public String getOpenId() {
			return openId;
		}

		public void setOpenId(String openId) {
			this.openId = openId;
		}

		public UUID getUuid() {
			return uuid;
		}

		public void setUuid(UUID uuid) {
			this.uuid = uuid;
		}

		public AddressDTO getAddress() {
			return address;
		}

		public void setAddress(AddressDTO address) {
			this.address = address;
		}
}
