package com.portfolio.dto;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.TimeZone;

import org.springframework.web.multipart.MultipartFile;

public class Constants {
	
	
	public static final String LOCAL_IMG_LOCATION = "save_image/";
//	public static final String LOCAL_BASE_DIR="D:\\Spring_boot\\complete_backend\\src\\main\\resources\\static\\";
	public static final String LOCAL_BASE_DIR="C:\\Users\\premk\\Desktop\\MyPortfolio\\MyPortfolio\\src\\main\\resources\\static";
	

	public static final String invalidData = "invalidData";
	public static final String requestSuccess = "requestSuccess";

	public static final String user_Info = "USER_INFO";
	public static final String loginSuccess = "You are loged in successfully !!";
	public static final String loginFirst = "You are not login please login !!";
	public static final String paymentNotDone = "Your payment is still outstanding. !!";
	

	public static final String accountNotVerified = "Your account is not verified !!";
	public static final String billingdocumentVerified = "Your payment is not paid !!";
	//Document Verify
	public static final String applicationReject = "Your application is rejected !!";
	public static final String applicationPendig = "Your application is pending !!";
	public static final String applicationVerify = "Your application is verified!!";
	// public static final String unathorized = "unathorized";
	public static final String documentNotVerified = "Your all documents and payment are not done !!";
	public static final String documentVerified = "Your all documents  are not verify !!";
	public static final String permission = "Permission denied !!";
	
	public static final String dataGetSucceed = "Data fatch successfully !!";
	public static final String recordNotFound = "Record  not found !!";
	public static final String recordDelete = "Record delete successfully !!";
	public static final String addData = "Data added successfully !!";
	public static final String updateData = "Data update successfully !!";
	public static final String userSignUp = "You are Register successfully please verify your account and login !!";
	public static final String accountVerified = "Your account verified successfully!!";
	public static final String accountVerifiedAlready = "Your account is alredy verified !!";
	public static final String invalidCredentials = "Username and password are incorrect !!";
	public static final String loginStatus = "Please Login first !!";
	public static final String requiredField = "Required field are not empty !!";
	public static final String logOut = "You have successfully logged out... !!";
	public static final String unathorized = " Unable to login. Incorrect username and password. Please Enter Correct username and Password. ";
	public static final String deleteOnlyAdmin = "You do not have permission to delete admin is only to delete !!";
	public static final String updateOnlyAdmin = "You do not have permission to update admin is only to update !!";
	public static final String portAndLocationNotAvailable = "Port and Location are not available !!";
	public static final String oldPassword = "This Password is not match to old password !!";
	public static final String success = "Saved Successfully !!!!!";

	public static String getRandomPassword() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@!$_";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 8) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static String getDateAndTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		return String.valueOf(df.format(new Date()));
	}

	public static String getDateAndTimeWithSec() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		return String.valueOf(df.format(new Date()));
	}

	public static String genrateOTP() {
		Random rndm_method = new Random();
		int[] otp = rndm_method.ints(6, 0, 9).toArray();
		StringBuilder sb = new StringBuilder();
		sb.append(otp[0]);
		sb.append(otp[1]);
		sb.append(otp[2]);
		sb.append(otp[3]);
		sb.append(otp[4]);
		sb.append(otp[5]);
		return sb.toString();
	}

	public static String saveMultiPartFile(MultipartFile file, String path, String fileNameWithExtension) {
		if (file != null) {
			File dir = new File(path + File.separator);

			if ((!dir.exists()) && (dir.mkdirs())) {
				System.out.println("Directory Created Successfully ");
			}
			dir = new File(path + File.separator + fileNameWithExtension);

			System.out.println("ABSOLUTE_PATH ::: " + dir.getAbsolutePath());
			try {
				FileOutputStream fileOuputStream = new FileOutputStream(dir);
				Throwable localThrowable3 = null;
				try {
					fileOuputStream.write(file.getBytes());
					fileOuputStream.flush();
					fileOuputStream.close();
				} catch (Throwable localThrowable1) {
					localThrowable3 = localThrowable1;
					throw localThrowable1;
				} finally {
					if (fileOuputStream != null) {
						if (localThrowable3 != null) {
							try {
								fileOuputStream.close();
							} catch (Throwable localThrowable2) {
								localThrowable3.addSuppressed(localThrowable2);
							}
						} else {
							fileOuputStream.close();
						}
					}
				}
			} catch (Exception e) {
				System.out.println(" ::: EXCEPTION in save file ::: " + e.getMessage());
			}
		}
		return fileNameWithExtension;
	}

	public static HashMap<String, Long> adminResp = new HashMap<String, Long>();

	public static void adminRespId() {
		System.err.println("::: Constants.Responsibities 123:::");

		
		adminResp.put("addLanguage", 1L);
		adminResp.put("getLanguageList", 2L);
		adminResp.put("getLanguageById", 3L);
		adminResp.put("updateLanguageById", 4L);
		adminResp.put("updateLanguageByStatus", 5L);
		adminResp.put("updateLanguageIsDefault", 6L);
		adminResp.put("removeLanguageById", 7L);

		// Noc Location
		adminResp.put("addAgreement", 8L);
		adminResp.put("getAgreementList", 9L);
		adminResp.put("getAgreementById", 10L);
		adminResp.put("updateAgreementById", 11L);
		adminResp.put("updateAgreementByStatus", 12L);
		adminResp.put("removeAgreementById", 13L);
		// Noc Location
		adminResp.put("getNocLocationList", 14L);
		adminResp.put("addNocLocation", 15L);
		adminResp.put("getNocLocationById", 16L);
		adminResp.put("updateNocLocationById", 17L);
		adminResp.put("updateNocLocationByStatus", 18L);
		adminResp.put("removeNocLocationById", 19L);
		// logo and Address

		adminResp.put("addLogoDetails", 20L);
		adminResp.put("getLogoDetailsList", 21L);
		adminResp.put("getLogoDetailsById", 22L);
		adminResp.put("updateLogoById", 23L);
		adminResp.put("updateLogoByStatus", 24L);
		adminResp.put("removeLogoById", 25L);

		// Quick Links
		adminResp.put("addQuicklinks", 26L);
		adminResp.put("getQuicklinksList", 27L);
		adminResp.put("getQuicklinksById", 28L);
		adminResp.put("updateQuicklinksById", 29L);
		adminResp.put("updateQuicklinksByStatus", 30L);
		adminResp.put("removeQuicklinksById", 31L);

		// Main Banner
		adminResp.put("addMainBanner", 32L);
		adminResp.put("getAllBannerImage", 33L);
		adminResp.put("getBannerImageByid", 34L);
		adminResp.put("updateMainBanner", 35L);
		adminResp.put("updateMainBannerStatus", 36L);
		adminResp.put("removeMainBannerById", 37L);

		// Footer Details
		adminResp.put("addFooterDetails", 38L);
		adminResp.put("getFooterDetails", 39L);
		adminResp.put("getFooterByid", 40L);
		adminResp.put("updateFooter", 41L);
		adminResp.put("updateFooterStatus", 42L);
		adminResp.put("removeFooterById", 43L);

		// Global Image Details
		adminResp.put("addGlobalImage", 44L);
		adminResp.put("getAllGlobalImage", 45L);

		// Isp Member Details
		adminResp.put("addIspMember", 46L);
		adminResp.put("getIspMemberList", 47L);
		adminResp.put("getIspMemberByid", 48L);
		adminResp.put("updateIspMember", 49L);
		adminResp.put("updateIspMemberByStatus", 50L);
		adminResp.put("removeIspMember", 51L);
		// Gallary Details

		adminResp.put("addGallaryImage", 52L);
		adminResp.put("getGallaryList", 53L);
		adminResp.put("getGallaryByid", 54L);
		adminResp.put("updateGallary", 55L);
		adminResp.put("updateGallaryByStatus", 56L);
		adminResp.put("removeGallary", 57L);

		// latest update of
		adminResp.put("addNews", 58L);
		adminResp.put("getNewsList", 59L);
		adminResp.put("getNewsByid", 60L);
		adminResp.put("updateNews", 61L);
		adminResp.put("updateNewsByStatus", 62L);
		adminResp.put("removeNews", 63L);

		// Ceo Message
		adminResp.put("addCeoDetails", 64L);
		adminResp.put("getCeoList", 65L);
		adminResp.put("getCeoByid", 66L);
		adminResp.put("updateCeoMessage", 67L);
		adminResp.put("updateCeoByStatus", 68L);
		adminResp.put("removeCeoMessage", 69L);

		// Service Details
		adminResp.put("addServiceDetails", 70L);
		adminResp.put("getServiceList", 71L);
		adminResp.put("getServiceByid", 72L);
		adminResp.put("updateService", 73L);
		adminResp.put("updateServiceByStatus", 74L);
		adminResp.put("removeService", 75L);

		// Global Setting Details
		adminResp.put("addGlobalSetting", 76L);
		adminResp.put("getGlobalSettingList", 77L);
		adminResp.put("getGlobalSettingByid", 78L);
		adminResp.put("updateGlobalSetting", 79L);
		adminResp.put("updateGlobalSettingByStatus", 80L);
		adminResp.put("removeGlobalSetting", 81L);

		// Become Member Details
		adminResp.put("addBecomeMember", 82L);
		adminResp.put("getBecomeMemberList", 83L);
		adminResp.put("getBecomeMemberByid", 84L);
		adminResp.put("updateBecomeMember", 85L);
		adminResp.put("updateBecomeMemberByStatus", 86L);
		// adminResp.put("removeBecomeMember", 87L); getPageList

		// Page Details
		adminResp.put("getPageList", 88L);
		adminResp.put("addJudgementOrders", 89L);

		// Referal Code Details
		adminResp.put("addReferalCode", 90L);
		adminResp.put("getReferalCode", 91L);
		adminResp.put("getReferalCodeById", 92L);
		adminResp.put("updateReferalCode", 93L);
		adminResp.put("updateReferalCodeByStatus", 94L);
		adminResp.put("removeReferalCode", 95L);
		adminResp.put("removeUser", 96L);
		adminResp.put("removePage", 97L);

		// Home Page DetailsCounter
		adminResp.put("getCounterDetailsList", 98L);
		adminResp.put("updateCounter", 99L);
		adminResp.put("removeNocContatctDetails", 100L);
		adminResp.put("getAllNocLocationList", 101L);
		adminResp.put("addNetworkMember", 101L);
		adminResp.put("addCounterDetailsList", 102L);
		
		adminResp.put("changePassword", 2370L);
		adminResp.put("updateProfile", 2371L);
		adminResp.put("removeRole", 2372L);
		adminResp.put("getSettingTypeList", 2373L);
		adminResp.put("addSettingType", 2374L);
		adminResp.put("getSettingsById", 2375L);
		adminResp.put("updateSettingTypeByid", 2376L);
		adminResp.put("getFooterLogoList", 2377L);
		
		
		

	}

	public static HashMap<String, Long> memberResp = new HashMap<String, Long>();

	public static void memberRespId() {
		System.err.println("::: Constants.responsibility for Member :::");

		memberResp.put("getMemberProfile", 301L);
		memberResp.put("updateMemberProfile", 302L);

		memberResp.put("getReferalsCode", 316L);

		// Ordinary Membership Form
		memberResp.put("downloadAgriment", 303L);
		memberResp.put("checkAndProcess", 304L);
		memberResp.put("addOrganizationDetails", 305L);
		memberResp.put("addConnectionType", 306L);
		memberResp.put("addNomineeDetails", 307L);
		memberResp.put("addDocumentationDetails", 308L);

		// Connection Form
		memberResp.put("addConnectionDetails", 309L);
		memberResp.put("addConnectionMemberDetails", 310L);
		memberResp.put("addBillingDetails", 311L);
		memberResp.put("addTechnicalDetails", 312L);
		memberResp.put("addCurrentPeeringConnectivity", 313L);
		memberResp.put("addBGPDetails", 314L);
		memberResp.put("getMemberConnectionDetailsList", 315L);
		// memberResp.put("getMemberDashboardPort", 316L);

	}

	public static HashMap<String, Long> memberAdminResp = new HashMap<String, Long>();

	public static void memberAdminRespId() {
		// Member Admin
		memberAdminResp.put("getUserData", 201L);
		memberAdminResp.put("updateMemberAdmin", 202L);
		memberAdminResp.put("memberChangePassword", 203L);
		memberAdminResp.put("logoutMemberAdmin", 204L);
		memberAdminResp.put("updateMemberProfiles", 205L);
		memberAdminResp.put("getUsersDetails", 206L);
		memberAdminResp.put("getAssosiateDetailsList", 207L);
		memberAdminResp.put("getOrdinaryDetails", 208L);
		memberAdminResp.put("getOrdinaryDetailsById", 209L);
		memberAdminResp.put("updateCopyOfAgreementStatus", 210L);
		memberAdminResp.put("updatePancardStatus", 211L);
		memberAdminResp.put("updateISPLicenseStatus", 212L);
		memberAdminResp.put("updateCompanyGstStatus", 213L);
		memberAdminResp.put("getNotification", 214L);
		memberAdminResp.put("updateNotificationss", 215L);
		memberAdminResp.put("uploadCopyOfAgreement", 216L);
		memberAdminResp.put("uploadPancards", 217L);
		memberAdminResp.put("uploadCompanyGst", 218L);
		memberAdminResp.put("uploadISPLicense", 219L);
		memberAdminResp.put("assignsBy", 220L);
		memberAdminResp.put("updateUserAccounts", 221L);
		memberAdminResp.put("getPaidUnpaid", 222L);

		memberAdminResp.put("assignsByBilling", 223L);
		memberAdminResp.put("checkPortAbility", 224L);
		memberAdminResp.put("checkLocantionAbility", 225L);
		memberAdminResp.put("checkPayment", 226L);
		memberAdminResp.put("getVerifiedList", 227L);
		memberAdminResp.put("portAllocate", 228L);
		memberAdminResp.put("uploadWhoIsFile", 229L);
		memberAdminResp.put("updateWhoisFileStatus", 230L);
		memberAdminResp.put("getCcuDetails", 231L);
		memberAdminResp.put("getdataByapplicationno", 231L);
		memberAdminResp.put("getIXTeamDetails", 232L);
		memberAdminResp.put("assignToIXTeam", 233L);
		memberAdminResp.put("verifyKycDocument", 234L);
		memberAdminResp.put("getPaidUnpaidApplication", 235L);
		memberAdminResp.put("getApplicationAproved", 236L);
		memberAdminResp.put("getBillingDetails", 237L);
		memberAdminResp.put("getNewPortrequest", 238L);
		memberAdminResp.put("billingAssignToIXTeam", 239L);
		memberAdminResp.put("uploadCertificatesOfIncorporation", 240L);
		memberAdminResp.put("uploadBoardResolution", 241L);
		memberAdminResp.put("uploadAuthorizedSignatory", 242L);
		memberAdminResp.put("verifyAllDocuments", 243L);
		
	}
	
}
