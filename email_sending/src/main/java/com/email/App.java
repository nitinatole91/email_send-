package com.email;

public class App {
	
public static void main(String[] args) {
	String to="nitinatole91@gmail.com";
	
	String from="nitin.atole70@gmail.com";
	
	String subject="Passionate Java Developer Ready to Drive Innovation";
	
	String text="I hope you're doing well. I came across the Java Developer position on LinkedIn and was immediately applying for it.\r\n"
			+ "\r\n"
			+ "With a fresh perspective and a passion for coding, I am excited about the opportunity to contribute to your innovative projects. Here are a few reasons why I believe I'd be a great fit for your team:\r\n"
			+ "\r\n"
			+ "- Proficient in Java and eager to apply my skills to real-world challenges\r\n"
			+ "- Strong problem-solving abilities and a collaborative mindset\r\n"
			+ "- Dedicated to staying updated with industry trends and technologies.\r\n"
			+ "\r\n"
			+ "Looking forward to the possibility of working together.\r\n"
			+ "\r\n"
			+ "Best regards,\r\n"
			+ "Nitin Atole\r\n"
			+ "+917038393634";
	
	
	GEmailSender gEmailSender=new GEmailSender();
	boolean b=gEmailSender.sendEmail(to, from, subject,text);
	if(b) {
		System.out.println("Email is sussesfully send!..");
	}else{
		System.out.println("Email is not run!...");
	}
}
}
