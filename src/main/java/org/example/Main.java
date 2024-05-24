package org.example;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {


    public static void main(String[] args) throws IOException {


        Prisoners prisoners = new Prisoners();
        SecurityHuman warden = new SecurityHuman();
        KapitanSecurityHuman kapitanSecurity = new KapitanSecurityHuman();
        JailBreakServices JailServices = new JailBreakServices();
        GlavaSecurityService glavaSecurity = new GlavaSecurityService();

        String[] names = {"Иван", "Петр", "Анна"};
        Log my_log;
        my_log = new Log("MenuLogg");
        System.out.print("Какую роль или услуги вы хотите выбрать?\n1.Заключенный\n2.Надзиратель\n3.Главный надзиратель\n4.Услуги тюрьмы\n5.Глава Службы безопасности\n6.Выйти\n");
        Scanner scanner = new Scanner(System.in);
        try {
            int Role = scanner.nextInt();


            switch (Role) {
                case 1:
                    while (true) {
                        System.out.print("\n1.Зарегистрироваться\n2.Обновить информацию\n3.Сгенерировать номер заключенного\n4.Выйти покурить\n5.Выход\n");
                        Scanner scannerPrisoner = new Scanner(System.in);
                        int RolePrisoner = scannerPrisoner.nextInt();

                        switch (RolePrisoner) {
                            case 1:
                                String[] lastNames = {"Иванов", "Петров", "Антонова"};
                                int[] ages = {25, 35, 28};
                                String[] criminalHistories = {"Первичное нарушение", "Многократный правонарушитель", "Условно осужденный", "Жестокий преступник"};
                                prisoners.registerNewPrisoners(names, lastNames, ages, criminalHistories);
                                break;
                            case 2:
                                String[] updatedCriminalHistories = {"Обновление личного дела 1", "Обновление личного дела 2", "Обновление личного дела 3"};
                                prisoners.updatePrisonerInformation(names, null, updatedCriminalHistories);
                                break;
                            case 3:
                                System.out.println("Рандомный номер Заключенного: " + prisoners.generateRandomInmateCode());
                                break;
                            case 4:
                                prisoners.ExitSmoke();
                                break;
                            case 5:
                                return;
                        }
                    }
                case 2:
                    while (true) {
                        System.out.print("\n1.Узнать разрешение на посещение\n2.Рассчитать дату освобождения заключенного\n3.Узнать местоположение заключенного\n4.Пойти покурить\n5.Выход\n");
                        Scanner scannerWarden = new Scanner(System.in);
                        int RoleWarden = scannerWarden.nextInt();
                        switch (RoleWarden) {
                            case 1:
                                warden.checkVisitorPermissions("Марк", true);
                                break;
                            case 2:
                                int remainingSentence = 36;
                                int daysServed = 12;
                                System.out.println("Release date: " + warden.calculateInmateReleaseDate(remainingSentence, daysServed));
                                break;
                            case 3:
                                warden.searchPrisonerLocation("Имя заключенного");
                                break;
                            case 4:
                                System.out.print("Выберите где будете курить\n 1.На улице\n 2.В офицерской комнате\n 3.Выход\n");
                                warden.ExitSmoke(scanner.nextInt());
                                break;
                            case 5:
                                return;
                        }
                    }
                case 3:
                    while (true) {
                        System.out.print("\n1.Назначить охраника на определенную зону\n2.Выход\n");
                        Scanner scannerKapitan = new Scanner(System.in);
                        int RoleKapitan = scannerKapitan.nextInt();
                        switch (RoleKapitan) {
                            case 1:
                                String[] guardNames = {"Охраник1", "Охраник2", "Охраник3"};
                                String[] areas = {"Область1", "Область2", "Область3"};
                                Random random = new Random();
                                kapitanSecurity.assignGuardToArea(guardNames[random.nextInt(guardNames.length)], areas[random.nextInt(areas.length)]);
                                break;
                            case 2:
                                return;
                        }
                    }
                case 4:
                    while (true) {
                        System.out.print("\n1.Узнать расписание еды\n2.Медицинские услуги\n3.Выход\n");
                        Scanner scannerJailService = new Scanner(System.in);
                        int RoleJailService = scannerJailService.nextInt();
                        switch (RoleJailService) {
                            case 1:
                                String[] menus = {"Суп", "Рыба", "Мясо"};
                                int[] portionSizes = {200, 300, 400};
                                int[] daysOfWeek = {1, 2, 3};
                                JailServices.manageFoodSchedule(menus, portionSizes, daysOfWeek);
                                break;
                            case 2:
                                String[] names2 = {"Мария", "Сергей", "Елена"};
                                String[] medicalConditions = {"Здоров", "Хронический бронхит", "Астма"};
                                double[] appointmentDates = {1.0, 2.0, 3.0};
                                JailServices.manageMedicalServices(names2, medicalConditions, appointmentDates);
                                break;
                            case 3:
                                return;
                        }
                    }
                case 5:
                    while (true) {
                        System.out.print("\n1.Рассчитать индекс переполненности тюрем\n2.Узнать вероятность освобождения заключенного\n3.Узнать вероятность на ближайшее освобождение заключенного\n4.рассчитать эффективность графика охраны\n5.Выход\n");
                        Scanner scannerGlavaSecurity = new Scanner(System.in);
                        int RoleGlavaSecurity = scannerGlavaSecurity.nextInt();
                        switch (RoleGlavaSecurity) {
                            case 1:
                                int numberOfPrisoners = 1000;
                                int prisonCapacity = 800;
                                double resourceAvailability = 0.8;
                                double prisonerHealthAndSafetyImpact = 0.5;
                                double overcrowdingIndex = glavaSecurity.calculatePrisonOvercrowdingIndex(numberOfPrisoners, prisonCapacity, resourceAvailability, prisonerHealthAndSafetyImpact);
                                System.out.println("Индекс переполненности тюрем составляет: " + overcrowdingIndex);
                                break;
                            case 2:
                                double rehabilitationProbability = glavaSecurity.calculatePrisonerReProbability("Минимальный", 35, 12, true);
                                System.out.println("Предполагаемая вероятность освобождения: " + rehabilitationProbability);
                                break;
                            case 3:
                                double earlyReleaseProbability = glavaSecurity.calculateDosrochnogoosvobojdenia(1, 35, 12);
                                System.out.println("Предполагаемая вероятность досрочного освобождения составляет: " + earlyReleaseProbability);
                                break;
                            case 4:
                                double guardScheduleEfficiency = glavaSecurity.calculateGuardScheduleEfficiency(4, 8, 35, 12);
                                System.out.println("Предполагаемая эффективность расписания охраны: " + guardScheduleEfficiency);
                                break;
                            case 5:
                                return;
                        }
                    }
                case 6:
                    return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            my_log.logger.warning(e.toString());
        }

    }
}




 class Prisoners {
     static Log my_log;

     static {
         try {
             my_log = new Log("PrisonersLogg.log");
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     public static void registerNewPrisoners(String[] names, String[] lastNames, int[] ages, String[] criminalHistories) throws IOException {


         my_log.logger.info("Зарегистрирован новый заключенный");
         try {
             for (int i = 0; i < names.length; i++) {
                 System.out.println("Новый заключенный:");
                 System.out.println("Имя: " + names[i]);
                 System.out.println("Фамилия: " + lastNames[i]);
                 System.out.println("Возраст: " + ages[i]);
                 System.out.println("Уровень уголовной истории: " + criminalHistories[i]);
                 System.out.println("-----------------------------------");
             }
         }catch (Exception e){
             my_log.logger.warning("Зарегистрирован новый заключенный x2");
         }
     }

     public static void updatePrisonerInformation(String[] names, Integer[] prisonerNumbers, String[] updatedCriminalHistories) {

         my_log.logger.info("Информация об заключенном обновлена");
         try {
             for (int i = 0; i < names.length; i++) {
                 System.out.println("Обновление информации о заключенном:");
                 System.out.println("Имя: " + names[i]);
                 System.out.println("№ заключенного: " + (prisonerNumbers != null ? prisonerNumbers[i] : "Не указан"));
                 System.out.println("Обновленная уголовная история: " + updatedCriminalHistories[i]);
                 System.out.println("-----------------------------------");
             }
         }catch (Exception e){
             my_log.logger.warning("Информация об заключенном обновлена x2");
         }
     }

     public static String generateRandomInmateCode() {
         my_log.logger.severe("Рандомная комната для заключенного сгенерированна x2");
         my_log.logger.info("Рандомная комната для заключенного сгенерированна");

         Random random = new Random();
         int randomNum = random.nextInt(1000);
         return "AB" + randomNum; // Пример формата кода заключенного
     }

     public void ExitSmoke() {


         my_log.logger.info("Заключенный вышел покурить");
         try {
             Random random = new Random();
             int randomNum = random.nextInt(60);
             System.out.print("Вы вышли покурить на: " + randomNum + " минут");
         }catch (Exception e){
             my_log.logger.warning("Заключенный вышел покурить x2");
         }
     }

     public void ExitSmoke(int positionsSmoke) {

         my_log.logger.severe("Офицер вышел покурить x2");
         my_log.logger.info("Офицер вышел покурить");

         String[] positions = new String[]{"на улицу", "в офицерскую комнату"};
         Random random = new Random();
         int randomNum = random.nextInt(60);
         switch (positionsSmoke) {
             case 1:
                 System.out.print("Вы вышли покурить на: " + randomNum + " минут " + positions[0]);
                 break;
             case 2:
                 System.out.print("Вы вышли покурить на: " + randomNum + " минут " + positions[1]);
                 break;
             case 3:
                 return;
         }
     }
 }



     class SecurityHuman extends Prisoners {
         static Log my_log;
         static{
             try{
                 my_log = new Log("SecurityHumanLogge.log");
             }catch(IOException e){
                 e.printStackTrace();
             }
         }
        public static boolean checkVisitorPermissions(String visitorName, boolean hasVisitorPass) {

            my_log.logger.severe("Офицер проверил разрешение заключенного на посещение x2");
            my_log.logger.info("Офицер проверил разрешение заключенного на посещение");

            if (hasVisitorPass) {
                System.out.println(visitorName + " имеет разрешение на посещение.");
                return true;
            } else {
                System.out.println(visitorName + " не имеет соответствующего разрешения.");
                return false;
            }
        }
         public static String calculateInmateReleaseDate(int remainingSentence, int daysServed) {

             my_log.logger.severe("Произошел процесс подсчет даты x2");
             my_log.logger.info("Произошел процесс подсчет даты");

                System.out.println(new Date().getYear());
             int yearsLeft = remainingSentence - daysServed;
             int releaseYear = (new Date().getYear() + 1900) + (yearsLeft / 365);
             int releaseMonth = (new Date().getMonth() + 1) + (yearsLeft % 365) / 30;
             int releaseDay = (new Date().getDate() + 1) + ((yearsLeft % 365) % 30);

             DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
             return df.format(new Date(releaseYear - 1900, releaseMonth - 1, releaseDay));
         }
         public static void searchPrisonerLocation(String inmateName) {

             // Логика поиска местоположения заключенного

             my_log.logger.severe("Местоположение заключенного x2");
             my_log.logger.info("Местоположение заключенного");

             System.out.println("Местоположение заключенного " + inmateName + ": Блок X, камера Y.");
         }

    }
    class KapitanSecurityHuman{
        static Log my_log;
        static{
            try{
                my_log = new Log("KapitanSecurityHumanLogg.log");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        public static void assignGuardToArea(String guardName, String area) {

            my_log.logger.severe("Назначен охранник на определенную зону x2");
            my_log.logger.info("Назначен охранник на определенную зону");
            // Логика назначения охранника на определенную зону
            System.out.println("Охранник " + guardName + " назначен на зону: " + area);
        }

    }

class JailBreakServices{
    static Log my_log;
    static{
        try{
            my_log = new Log("JailBreakServicesLogg.log");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void manageFoodSchedule(String[] menus, int[] portionSizes, int[] daysOfWeek) {

        my_log.logger.severe("Заключенный посмотрел меню еды x2");
        my_log.logger.info("Заключенный посмотрел меню еды");
        Random random = new Random();
        System.out.println("Расписание питания:");
        for (int i = 0; i < daysOfWeek.length; i++) {
            System.out.println("День недели: " + daysOfWeek[i]);
            System.out.println("Меню: " + menus[random.nextInt(menus.length)]);
            System.out.println("Размер порции: " + portionSizes[random.nextInt(portionSizes.length)]);
            System.out.println("-----------------------------------");
        }
    }

    public void manageMedicalServices(String[] names, String[] medicalConditions, double[] appointmentDates) {

        my_log.logger.severe("Была произведенна проверка на медицинское состояние x2");
        my_log.logger.info("Была произведена проверка на медицинское состояние");
        System.out.println("Медицинские услуги:");
        for (int i = 0; i < names.length; i++) {
            System.out.println("Имя: " + names[i]);
            System.out.println("Медицинское состояние: " + medicalConditions[i]);
            System.out.println("Дата последнего осмотра: " + appointmentDates[i]);
            System.out.println("-----------------------------------");
        }
    }
}
class GlavaSecurityService{
    static Log my_log;
    static{
        try{
            my_log = new Log("GlavaSecurityServiceLogg.log");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public  double calculatePrisonOvercrowdingIndex(int numberOfPrisoners, int prisonCapacity, double resourceAvailability, double prisonerHealthAndSafetyImpact) {

        my_log.logger.severe("Был вычислен индекс перенаселенности населения x2");
        my_log.logger.info("Был вычислен индекс перенаселенности населения");
        double prisonersToCapacityWeight = 0.6;
        double resourceAvailabilityWeight = 0.2;
        double prisonerHealthAndSafetyImpactWeight = 0.2;

        double prisonersToCapacityScore = (numberOfPrisoners / (double) prisonCapacity) - 1.0;
        double resourceAvailabilityScore = (resourceAvailability >= 0.8) ? 1.0 : 0.5;
        double prisonerHealthAndSafetyImpactScore = (prisonerHealthAndSafetyImpact <= 0.5) ? 1.0 : 0.5;

        double overcrowdingIndex = (prisonersToCapacityWeight * prisonersToCapacityScore)
                + (resourceAvailabilityWeight * resourceAvailabilityScore)
                + (prisonerHealthAndSafetyImpactWeight * prisonerHealthAndSafetyImpactScore);
        return overcrowdingIndex;
    }

    public  double calculatePrisonerReProbability(String criminalHistory, int age, int educationLevel, boolean participationInRehabPrograms) {

        my_log.logger.severe("Был вычислена вероятность возникновения проблемы x2");
        my_log.logger.info("Была вычислена вероятность возникновения проблемы");
        double criminalHistoryWeight = 0.3;
        double ageWeight = 0.2;
        double educationLevelWeight = 0.3;
        double rehabProgramsWeight = 0.2;

        double criminalHistoryScore = (criminalHistory.equals("Минимальный")) ? 1.0 : 0.5;
        double ageScore = (age >= 30) ? 1.0 : 0.5;
        double educationLevelScore = (educationLevel >= 12) ? 1.0 : 0.5;
        double participationInRehabProgramsScore = (participationInRehabPrograms) ? 1.0 : 0.5;

        double rehabilitationProbability = (criminalHistoryWeight * criminalHistoryScore)
                + (ageWeight * ageScore)
                + (educationLevelWeight * educationLevelScore)
                + (rehabProgramsWeight * participationInRehabProgramsScore);
        return rehabilitationProbability;
    }

    // Added functions
    public  double calculateDosrochnogoosvobojdenia(int remainingSentence, int Otbitoevremia, double Progressrehabilitation) {

        my_log.logger.severe("Было рассчитано на ближайшее освобождение x2");
        my_log.logger.info("Было рассчитано на ближайшее освобождение");
        double sentenceCompletionWeight = 0.6;
        double OtbitoevremiaWeight = 0.2;
        double ProgressrehabilitationWeight = 0.2;

        double sentenceCompletionScore = (Otbitoevremia / (double) remainingSentence) - 1.0;
        double OtbitoevremiaScore = (Otbitoevremia >= remainingSentence / 2) ? 1.0 : 0.5;
        double rehabilitationProgressScore = (Progressrehabilitation >= 0.8) ? 1.0 : 0.5;

        double earlyReleaseProbability = (sentenceCompletionWeight * sentenceCompletionScore)
                + (OtbitoevremiaWeight * OtbitoevremiaScore)
                + (ProgressrehabilitationWeight * rehabilitationProgressScore);
        return earlyReleaseProbability;
    }
    public double calculateGuardScheduleEfficiency(int numberOfGuards, int prisonCapacity, double guardTrainingCompletionRate, double guardSickDays) {

        my_log.logger.severe("Было рассчитанно эффективность защитного графика x2");
        my_log.logger.info("Было рассчитанно эффективность защитного графика");
        double guardToPrisonerRatioWeight = 0.4;
        double guardTrainingCompletionRateWeight = 0.3;
        double guardSickDaysWeight = 0.3;
        double guardToPrisonerRatioScore = (numberOfGuards / (double) prisonCapacity) - 1.0;
        double guardTrainingCompletionRateScore = (guardTrainingCompletionRate >= 0.8) ? 1.0 : 0.5;
        double guardSickDaysScore = (guardSickDays <= 0.05) ? 1.0 : 0.5;

        double guardScheduleEfficiency = (guardToPrisonerRatioWeight * guardToPrisonerRatioScore)
                + (guardTrainingCompletionRateWeight * guardTrainingCompletionRateScore)
                + (guardSickDaysWeight * guardSickDaysScore);
        return guardScheduleEfficiency;
    }

}



















































