package edu.digital.library;

public class LegacyLibraryAdapter implements DocumentProvider{
    private final LegacyLibraryAPI legacyLibraryAPI;

    public LegacyLibraryAdapter(LegacyLibraryAPI legacyLibraryAPI) {
        this.legacyLibraryAPI = legacyLibraryAPI;
    }

    @Override
    public Document getDocument(
            String documentId,
            String userId
    ) {

        int userNumber;

        try {
            userNumber = Integer.parseInt(userId);
        } catch (NumberFormatException e) {
            throw new DocumentAccessException(
                    "User ID must be a number."
            );
        }

        LegacyLibraryAPI.LegacyFile file =
                legacyLibraryAPI.fetchFile(
                        documentId,
                        userNumber,
                        1
                );

        if (file == null) {
            throw new DocumentAccessException(
                    "Legacy library returned no document."
            );
        }

        if (file.errorCode() == LegacyLibraryAPI.FILE_NOT_FOUND) {
            throw new DocumentAccessException(
                    "Document was not found."
            );
        }

        if (file.errorCode() == LegacyLibraryAPI.USER_NOT_AUTHORIZED) {
            throw new DocumentAccessException(
                    "User is not authorized."
            );
        }

        return new Document(
                documentId,
                file.fileName(),
                file.creator(),
                file.format()
        );
    }

}
