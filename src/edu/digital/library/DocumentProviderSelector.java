package edu.digital.library;

public class DocumentProviderSelector {
    public static DocumentProvider selectProvider(
            int choice
    ) {

        switch (choice) {

            case 1:
                return new LocalDocumentProvider();

            case 2:
                return new CloudDocumentProvider();

            case 3:
                return new LegacyLibraryAdapter(
                        new LegacyLibraryAPI()
                );

            default:
                throw new IllegalArgumentException(
                        "Unknown provider."
                );
        }
    }
}
