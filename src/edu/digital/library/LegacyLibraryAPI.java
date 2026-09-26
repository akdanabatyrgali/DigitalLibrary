package edu.digital.library;

public class LegacyLibraryAPI {
    public static final int SUCCESS = 0;
    public static final int FILE_NOT_FOUND = 404;
    public static final int USER_NOT_AUTHORIZED = 403;

    public LegacyFile fetchFile(
            String bookCode,
            int userNumber,
            int fileType
    ) {

        if ("missing".equalsIgnoreCase(bookCode)) {
            return new LegacyFile(
                    "",
                    "",
                    "",
                    FILE_NOT_FOUND
            );
        }

        if (userNumber <= 0) {
            return new LegacyFile(
                    "",
                    "",
                    "",
                    USER_NOT_AUTHORIZED
            );
        }

        String format;

        if (fileType == 1) {
            format = "PDF";
        } else {
            format = "EPUB";
        }

        return new LegacyFile(
                bookCode,
                "Legacy Library Collection",
                format,
                SUCCESS
        );
    }

    public record LegacyFile(
            String fileName,
            String creator,
            String format,
            int errorCode
    ) {
    }
}
