/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullah;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SendNotice implements Serializable {
    private String noticeName, noticeSubject, noticeForUserType;
    private LocalDate noticeDate;
    private String noticeDescription;

    public SendNotice(String noticeName, String noticeSubject, String noticeForUserType, LocalDate noticeDate, String noticeDescription) {
        this.noticeName = noticeName;
        this.noticeSubject = noticeSubject;
        this.noticeForUserType = noticeForUserType;
        this.noticeDate = noticeDate;
        this.noticeDescription = noticeDescription;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeSubject() {
        return noticeSubject;
    }

    public void setNoticeSubject(String noticeSubject) {
        this.noticeSubject = noticeSubject;
    }

    public String getNoticeForUserType() {
        return noticeForUserType;
    }

    public void setNoticeForUserType(String noticeForUserType) {
        this.noticeForUserType = noticeForUserType;
    }

    public LocalDate getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(LocalDate noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getNoticeDescription() {
        return noticeDescription;
    }

    public void setNoticeDescription(String noticeDescription) {
        this.noticeDescription = noticeDescription;
    }

   
    
}
