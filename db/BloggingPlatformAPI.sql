DROP DATABASE IF EXISTS BloggingPlatformAPI;
GO
CREATE DATABASE BloggingPlatformAPI;
GO
USE BloggingPlatformAPI;
CREATE TABLE dbo.Post
(
    ID        INT IDENTITY (1,1) NOT NULL PRIMARY KEY,
    Title     VARCHAR(255) NOT NULL,
    Content   VARCHAR(MAX) NOT NULL,
    Category  VARCHAR(255) NOT NULL,
    Tags      VARCHAR(255) NOT NULL,
    CreatedAt DATETIME DEFAULT GETDATE(),
    UpdatedAt DATETIME DEFAULT GETDATE()
)
GO
CREATE TRIGGER trg_Update_Post_UpdatedAt
    ON dbo.Post
    AFTER UPDATE
    AS
BEGIN
    SET NOCOUNT ON;

    UPDATE dbo.Post
    SET UpdatedAt = CURRENT_TIMESTAMP
    FROM dbo.Post p
             INNER JOIN inserted i ON p.ID = i.ID;
END
GO
