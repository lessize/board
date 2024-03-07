package com.kh.board.web;

import com.kh.board.domain.member.svc.MemberSVC;
import com.kh.board.web.api.ApiResponse;
import com.kh.board.web.api.ResCode;
import com.kh.board.web.req.member.ReqExistEmail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ApiMemberController {
  private final MemberSVC memberSVC;

  // 회원 중복 체크
  @PostMapping("/dupchk")
  public ApiResponse<?> dupchk(@RequestBody ReqExistEmail reqExistEmail) {
    ApiResponse<?> res = null;
    log.info("reqExistEmail={}", reqExistEmail);
    boolean existEmail = memberSVC.existEmail(reqExistEmail.getEmail());
    if (existEmail) {
      res = ApiResponse.createApiResponse(ResCode.EXIST.getCode(), ResCode.EXIST.name(), null);
    } else {
      res = ApiResponse.createApiResponse(ResCode.NONE.getCode(), ResCode.NONE.name(), null);
    }

    return res;
  }
}
