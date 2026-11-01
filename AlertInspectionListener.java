package com.aitu.lms.integration;
import com.aitu.lms.observer.*; import com.aitu.lms.visitor.*; import com.aitu.lms.domain.*; import java.time.Instant;
public final class AlertInspectionListener implements Observer { private final Subject subject; private final Element relatedSubtree; private final Visitor<Integer> credits; private final Visitor<Integer> workload; private final Visitor<java.util.List<Student>> filter; private final Visitor<String> json; private volatile InspectionReport lastReport;
 public AlertInspectionListener(Subject subject,Element relatedSubtree){this.subject=subject;this.relatedSubtree=relatedSubtree;this.credits=new CreditVisitor();this.workload=new WorkloadVisitor();this.filter=new StudentFilterVisitor(3.0);this.json=new JsonExportVisitor();}
 public void onEvent(Event e){if(e.type()!=EventType.ALERT)return; var report=new InspectionReport(e.studentId(),relatedSubtree.accept(credits),relatedSubtree.accept(workload),relatedSubtree.accept(filter).size(),relatedSubtree.accept(json)); lastReport=report; subject.publish(new Event(EventType.INSPECTION_REPORT,e.studentId(),"Inspection report: credits="+report.credits()+", workload="+report.workload(),Instant.now()));}
 public InspectionReport lastReport(){return lastReport;}
}
