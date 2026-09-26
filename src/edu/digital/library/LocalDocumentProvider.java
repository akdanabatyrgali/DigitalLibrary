package edu.digital.library;

public class LocalDocumentProvider implements DocumentProvider {
    @Override
    public Document getDocument(String documentId, String userId) {

        return new Document(
                documentId,
                "Local Library Document",
                "Local Author",
                "PDF"
        );
    }

}
