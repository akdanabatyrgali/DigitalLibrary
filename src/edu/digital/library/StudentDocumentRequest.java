package edu.digital.library;

public class StudentDocumentRequest extends DocumentRequest{
    public StudentDocumentRequest(
            DocumentProvider provider
    ) {
        super(provider);
    }

    @Override
    public Document requestDocument(
            String documentId,
            String userId
    ) {

        return provider.getDocument(
                documentId,
                userId
        );
    }

}
