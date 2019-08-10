package com.mycompany.onetomanydemo.dao;

import com.mycompany.onetomanydemo.model.Attachments;
import com.mycompany.onetomanydemo.model.Personnel;
import com.mycompany.onetomanydemo.model.Proposal;
import com.mycompany.onetomanydemo.model.Qualifications;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;

/**
 *
 * @author sakina
 */
public class ProposalDao implements BaseDao {

    private static Scanner sin = new Scanner(System.in);
    private static EntityTransaction entityTransaction;
    private static DetailsImpl detailsImpl;

    public ProposalDao() {
        
        detailsImpl = new DetailsImpl();
    }

    @Override
    public void getAll() {
        List<Proposal> objects = (List<Proposal>) detailsImpl.getAll("Proposal");
        objects.stream().map(ob -> ob.toString());
    }

    @Override
    public String add() {
        int noOfPersonnel, noOFAttachments;

        List<Personnel> personnels = new ArrayList<>();

        List<Attachments> attachment = new ArrayList<>();

        System.out.println("Enter number of personnel for proposal");
        noOfPersonnel = sin.nextInt();

        for (int i = 0; i < noOfPersonnel; i++) {
            Personnel per = new Personnel();
            per = savePersonnelDetails();
            System.out.println("Enter number of attachment for personal");
            noOFAttachments = sin.nextInt();
            for (int j = 0; j < noOFAttachments; j++) {
                Attachments att = new Attachments();
                att = saveAttachmentDetails();
                attachment.add(att);
            }
            personnels.add(per);
        }
        System.out.println("PERSONEL" + personnels.toString());

        System.out.println("att" + attachment.toString());

        Proposal pro = new Proposal();
        pro = saveProposalDetails(personnels, attachment);

        detailsImpl.save(pro);
        return "deatils added";
    }

    @Override
    public void delete() {
        System.out.println("Enter proposal title:");
        String title = sin.next();
        try {
            detailsImpl.delete("Proposal", 7);
            //detailsImpl.delete("Proposal", "title", title);
        } catch (Exception ex) {
            Logger.getLogger(ProposalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Proposal deleted..");
    }

    @Override
    public void update() {
        
        System.out.println("Enter id to update");
        Long id = sin.nextLong();
        int noOfPersonnel, noOFAttachments;

        List<Personnel> personnels = new ArrayList<>();

        List<Attachments> attachment = new ArrayList<>();

        System.out.println("Enter number of personnel for proposal");
        noOfPersonnel = sin.nextInt();

        for (int i = 0; i < noOfPersonnel; i++) {
            Personnel per = new Personnel();
            per = savePersonnelDetails();
            System.out.println("Enter number of attachment for personal");
            noOFAttachments = sin.nextInt();
            for (int j = 0; j < noOFAttachments; j++) {
                Attachments att = new Attachments();
                att = saveAttachmentDetails();
                attachment.add(att);
            }
            personnels.add(per);
        }

        System.out.println("Enter proposal title");
        String title = sin.next();
        System.out.println("Enter proposal description");
        String description = sin.next();
        
        Proposal pro = new Proposal(title,description,personnels,attachment);
        pro.setId(id);
        pro.toString();
        detailsImpl.update(pro);

    }

    public static Proposal saveProposalDetails(List<Personnel> personnel, List<Attachments> attachments) {

        String title, description;

        System.out.println("Enter proposal title");
        title = sin.next();
        System.out.println("Enter proposal description");
        description = sin.next();

        Proposal proposal = new Proposal(title, description, personnel, attachments);

        return proposal;

    }

    public static Attachments saveAttachmentDetails() {

        String filename, filesize, attachment;

        System.out.println("Enter file name");
        filename = sin.next();
        System.out.println("Enter file size");
        filesize = sin.next();
        System.out.println("Enter file attachment");
        attachment = sin.next();

        Attachments attachments = new Attachments(filename, filename, LocalDateTime.now(), attachment.getBytes());

        return attachments;
    }

    public static Personnel savePersonnelDetails() {

        int choice;
        String name, phone;
        Qualifications qualification = null;

        System.out.println("Enter name of personnnel ::");
        name = sin.next();

        System.out.println("Enter Qualifacation::");
        System.out.println("1. BEGINNER");
        System.out.println("2. INTERMIDIATE");
        System.out.println("3. PRO");

        choice = sin.nextInt();

        switch (choice) {
            case 1:
                qualification = Qualifications.Beginner;
                break;

            case 2:
                qualification = Qualifications.Intermediate;
                break;
            case 3:
                qualification = Qualifications.Pro;
                break;

            default:
                System.out.println("Enter valid number between 1-3");

        }

        System.out.println("Enter phone number ::");
        phone = sin.next();

        Personnel personnel = new Personnel(name, qualification, phone);
        return personnel;

    }

}
