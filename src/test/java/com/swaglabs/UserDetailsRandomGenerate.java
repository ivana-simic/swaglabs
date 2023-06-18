package com.swaglabs;

import com.github.javafaker.Faker;

public class UserDetailsRandomGenerate {

  private static Faker faker = new Faker();

  public static String generateRandomUsername(){
      return faker.name().username();
  }
  public static String generateRandomPassword(){
      return faker.internet().password();
  }

  public static String generateRandomFirstName(){
      return faker.name().firstName();
  }

  public static String generateRandomLastName(){
      return faker.name().lastName();
  }

  public static String generateRandomZipCode(){
      return faker.address().zipCode();
  }
}
