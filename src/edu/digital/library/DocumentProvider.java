package edu.digital.library;

public interface DocumentProvider {
    Document getDocument(String documentId, String userId);
}
