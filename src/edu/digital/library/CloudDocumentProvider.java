package edu.digital.library;

public class CloudDocumentProvider implements DocumentProvider{
    @Override
    public Document getDocument(String documentId, String userId) {

        return new Document(
                documentId,
                "Cloud Library Document",
                "Cloud Author",
                "EPUB"
        );
    }

}
