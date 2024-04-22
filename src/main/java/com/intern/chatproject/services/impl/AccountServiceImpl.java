package com.intern.chatproject.services.impl;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.intern.chatproject.entities.GoogleUserInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.io.IOException;
//import java.security.GeneralSecurityException;
//import java.util.Collections;
//
//@Service
//public class AccountService {
//
//    NetHttpTransport transport = new NetHttpTransport();
//    JsonFactory jsonFactory = new JacksonFactory();
//    private GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
//            .setAudience(Collections.singletonList("890054659261-fl3pla3surhpuoud6bd8e2s6h9g85ib2.apps.googleusercontent.com"))
//            .build();
//
//    public String loginOAuthGoogle(GoogleUserInfo requestBody) {
//        GoogleUserInfo account = verifyIDToken(requestBody.getG_csrf_token());
//        if (account == null) {
//            throw new IllegalArgumentException();
//        }
//        account = createOrUpdateUser(account);
//        return jwtUtils.createToken(account, false);
//    }
//
//    @Transactional
//    public GoogleUserInfo createOrUpdateUser(Account account) {
//        Account existingAccount = accountRepository.findByEmail(account.getEmail()).orElse(null);
//        if (existingAccount == null) {
//            account.setRoles("ROLE_USER");
//            accountRepository.save(account);
//            return account;
//        }
//        existingAccount.setFirstName(account.getFirstName());
//        existingAccount.setLastName(account.getLastName());
//        existingAccount.setPictureUrl(account.getPictureUrl());
//        accountRepository.save(existingAccount);
//        return existingAccount;
//    }
//
//    private GoogleUserInfo verifyIDToken(String idToken) {
//        try {
//            GoogleIdToken idTokenObj = verifier.verify(idToken);
//            if (idTokenObj == null) {
//                return null;
//            }
//            GoogleIdToken.Payload payload = idTokenObj.getPayload();
//            String firstName = (String) payload.get("given_name");
//            String lastName = (String) payload.get("family_name");
//            String email = payload.getEmail();
//            String pictureUrl = (String) payload.get("picture");
//
//            return new Account(firstName, lastName, email, pictureUrl);
//        } catch (GeneralSecurityException | IOException e) {
//            return null;
//        }
//    }
//}
