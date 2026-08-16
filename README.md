# springmvcstudy_02

Spring MVC의 요청 매핑, 요청·응답 데이터 처리와 HTTP 메시지 변환을 학습하는 예제 프로젝트입니다.

## 실행 환경

- Java 17
- Spring Boot 3.5.16
- Gradle 8.14.3 (Wrapper 포함)
- Spring MVC 6 / Jakarta Servlet 6
- Thymeleaf

## 빌드 및 실행

```powershell
.\gradlew.bat clean test bootJar
.\gradlew.bat bootRun
```

실행 후 `http://localhost:8080/`에서 예제 링크를 확인할 수 있습니다.

## 보안 및 의존성 점검

예제 로그는 요청 본문, 쿠키, 헤더 값과 사용자명을 원문으로 기록하지 않습니다. CycloneDX SBOM은 다음 명령으로 생성할 수 있습니다.

```powershell
.\gradlew.bat cyclonedxBom
```

결과는 `build/reports/cyclonedx/`에 생성됩니다.
