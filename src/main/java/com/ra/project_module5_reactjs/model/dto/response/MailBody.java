package com.ra.project_module5_reactjs.model.dto.response;

import lombok.Builder;

@Builder
public record MailBody (String to, String subject, String text){
}
