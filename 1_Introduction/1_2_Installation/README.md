# 소프트웨어 툴 설치

## OpenJDK 설치

- [Windows 설치 방법](OpenJDK/Win/README.md)
- [Mac 설치 방법](OpenJDK/Mac/README.md)
- [Linux 설치 방법](OpenJDK/Linux/README.md)

## Jetbrain IntelliJ IDEA

![IDEA](img/1.png)

- [IntelliJ IDEA Community 다운로드 페이지](https://www.jetbrains.com/ko-kr/idea/download/)
- 각 운영체제에 맞는 설치파일을 다운로드 받아 설치

## Git 설치

- [Windows Git 다운로드](https://git-scm.com/downloads)
- MacOS의 경우 `brew install git`으로 설치

## Git 설정 및 공개 키 생성

- Terminal을 연다 (bash, zsh)
  - Windows의 경우 Git Bash를 실행

- `git config`으로 username과 email을 설정

```bash
$ git config --global user.name "유저이름"
$ git config --global user.email 유저@이메일.com
```

- 공개 키 생성
  - `ssh-keygen` 입력 후, `Enter`를 세 번 누른다. (Passphrase 없이 생성)

```bash
$ ssh-keygen
```
