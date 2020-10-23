package com.lovemesomecoding.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "users", produces = "Rest API for user operations", tags = "User Controller")
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Sign Up")
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestHeader(name = "x-api-key") String xApiKey, @ApiParam(name = "user", required = true, value = "user") @RequestBody User user) {
        log.info("signUp(xApiKey={})", xApiKey);

        User savedUser = userService.signup(user);

        log.info("{}", savedUser.toString());

        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Get User")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@RequestHeader(name = "token") String token, @ApiParam(name = "id", required = true, value = "id") @PathVariable Long id) {
        log.info("getUser(token={})", token);

        User savedUser = userService.getUserById(id);

        log.info("{}", savedUser.toString());

        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Update User")
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestHeader(name = "token") String token, @ApiParam(name = "user", required = true, value = "user") @RequestBody User user) {
        log.info("updateUser(token={})", token);

        User savedUser = userService.update(user);

        log.info("{}", savedUser.toString());

        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Upload Document")
    @PostMapping(value = "/document", consumes = "multipart/form-data")
    public ResponseEntity<UploadFileResultDTO> uploadFile(@RequestHeader(name = "token") String token, @ApiParam(name = "file", required = true, value = "file") @RequestPart MultipartFile file) {
        log.info("uploadFiles(token={})", token);

        log.info("fileName={}", file.getOriginalFilename());
        log.info("fileSize={}", file.getSize());
        log.info("fileType={}", file.getContentType());

        return new ResponseEntity<>(new UploadFileResultDTO(true), HttpStatus.OK);
    }

    @ApiOperation(value = "Upload Documents")
    @PostMapping(value = "/documents", consumes = "multipart/form-data")
    public ResponseEntity<UploadFileResultDTO> uploadFiles(@RequestHeader(name = "token") String token,
            @ApiParam(name = "files", required = true, value = "files") @RequestPart List<MultipartFile> files) {
        log.info("uploadFiles(token={})", token);

        for (MultipartFile file : files) {
            log.info("fileName={}", file.getOriginalFilename());
            log.info("fileSize={}", file.getSize());
            log.info("fileType={}", file.getContentType());
            System.out.println();
        }

        return new ResponseEntity<>(new UploadFileResultDTO(true), HttpStatus.OK);
    }

}
