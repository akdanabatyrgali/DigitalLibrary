package edu.digital.library;

public class ResearchDocumentRequest extends DocumentRequest{
    public ResearchDocumentRequest(
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
