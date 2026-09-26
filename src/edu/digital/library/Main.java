package edu.digital.library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Digital Library ===");

        System.out.println("Choose document source:");
        System.out.println("1. Local Library");
        System.out.println("2. Cloud Library");
        System.out.println("3. Legacy Library");

        int source = scanner.nextInt();
        scanner.nextLine();

        DocumentProvider provider =
                DocumentProviderSelector.selectProvider(source);

        System.out.println();
        System.out.println("Choose request type:");
        System.out.println("1. Student");
        System.out.println("2. Researcher");

        int requestType = scanner.nextInt();
        scanner.nextLine();

        DocumentRequest request;

        if (requestType == 1) {
            request = new StudentDocumentRequest(provider);
        } else if (requestType == 2) {
            request = new ResearchDocumentRequest(provider);
        } else {
            System.out.println("Unknown request type.");
            return;
        }

        System.out.print("Enter document ID: ");
        String documentId = scanner.nextLine();

        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        try {

            Document document =
                    request.requestDocument(
                            documentId,
                            userId
                    );

            System.out.println();
            System.out.println("Document found:");
            System.out.println("ID: " + document.id());
            System.out.println("Title: " + document.title());
            System.out.println("Author: " + document.author());
            System.out.println("Format: " + document.format());

        } catch (DocumentAccessException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        scanner.close();
    }
}
