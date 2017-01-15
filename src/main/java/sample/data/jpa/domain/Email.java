/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String fromAddress;

    @Column(nullable = false)
    private String toAddress;

    @Column(nullable = true)
    private String subject;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "email")
    private Set<EmailStatus> emailStatuses = new HashSet<>();

    public Email() {
    }

    public Email(String fromAddress, String toAddress, String subject, Set<EmailStatus> emailStatuses) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.subject = subject;
        this.emailStatuses = emailStatuses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<EmailStatus> getEmailStatuses() {
        return emailStatuses;
    }

    public void setEmailStatuses(Set<EmailStatus> emailStatuses) {
        this.emailStatuses = emailStatuses;
    }
}
