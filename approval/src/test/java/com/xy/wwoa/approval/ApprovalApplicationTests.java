package com.xy.wwoa.approval;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xy.wwoa.common.util.JSONUtil;
import com.xy.wwoa.employee.model.EducationStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.transform.Source;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApprovalApplicationTests {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void contextLoads() {

    }

    public static void main(String[] args) throws JsonProcessingException {
        {
            List<Map<String, Object>> educationStatusList = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            map.put("schoolName", "娃哈哈");
            map.put("major", "计算机专业");
            map.put("education", "本科");
            map.put("fullTime", 1);
            map.put("enrollmentTime", "2019-08-31 00:00:00");
            map.put("graduationTime", "2019-08-31 00:00:00");
            educationStatusList.add(map);
            educationStatusList.add(map);
            educationStatusList.add(map);
            System.out.println(objectMapper.writeValueAsString(educationStatusList));
        }

        {
            List<Map<String, Object>> familyStatusList = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            map.put("memberFamily", "父亲");
            map.put("relationship", "父子");
            map.put("occupation", "程序员");
            familyStatusList.add(map);
            familyStatusList.add(map);
            familyStatusList.add(map);
            System.out.println(objectMapper.writeValueAsString(familyStatusList));
        }

        {
            List<Map<String, Object>> jobResumeList = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            map.put("companyName", "恒辉家园");
            map.put("post", "开发");
            map.put("startTime", "2018-05-01 08:00:00");
            map.put("endTime", "2019-05-01 08:00:00");
            map.put("telephone", "13000000000");
            map.put("quitReason", "无");
            map.put("witness", "西大大");
            jobResumeList.add(map);
            jobResumeList.add(map);
            jobResumeList.add(map);
            System.out.println(objectMapper.writeValueAsString(jobResumeList));
        }

    }

}
