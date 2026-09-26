package edu.digital.library;

public abstract class DocumentRequest {
    protected final DocumentProvider provider;

    public DocumentRequest(DocumentProvider provider) {
        this.provider = provider;
    }

    public abstract Document requestDocument(
            String documentId,
            String userId
    );
}
